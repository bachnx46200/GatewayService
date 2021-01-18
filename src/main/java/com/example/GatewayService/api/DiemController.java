package com.example.GatewayService.api;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import com.example.GatewayService.DTOs.*;
import com.example.GatewayService.entity.Khoi;
import com.example.GatewayService.entity.LopHoc;
import com.example.GatewayService.service.IKhoiService;
import com.example.GatewayService.service.ILopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.GatewayService.convert.DiemConvert;
import com.example.GatewayService.entity.Diem;
import com.example.GatewayService.export.DiemExcel;
//import com.example.GatewayService.export.DiemPDF;
import com.example.GatewayService.repository.IDiemRepository;
import com.example.GatewayService.service.IDiemService;
//import com.lowagie.text.DocumentException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class DiemController {
    @Autowired
    IKhoiService khoiService;

    @Autowired
    ILopHocService lopHocService;

    @Autowired
    IDiemService diemService;

    @Autowired
    DiemConvert diemConvert;

    @Autowired
    IDiemRepository idiemRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getall() {
        List<Diem> list = diemService.findAll();
        List<DiemDTO> DiemDTOS = new ArrayList<>();
        list.forEach(x -> DiemDTOS.add(diemConvert.toDTO(x)));
        return new ResponseEntity<>(DiemDTOS, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getbythem(@RequestParam(value = "tenlop", required = false) String tenlop,
                                       @RequestParam(value = "tenmon", required = false) String tenmon,
                                       @RequestParam(value = "hocki", required = false) boolean ki) {
        List<Diem> list = diemService.findByEVE(tenlop, tenmon, ki);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getByStudentId")
    ResponseEntity<?> getBy(@RequestParam(value = "id", required = false) UUID id,
                            @RequestParam(value = "hocki", required = false) String ki) {
        List<Diem> list = diemService.findByStudetID(id, ki.equals("true") ? true : false);
        List<DiemDTO> DiemDTOS = new ArrayList<>();
        list.forEach(x -> DiemDTOS.add(diemConvert.toDTO(x)));
        return new ResponseEntity<>(DiemDTOS, HttpStatus.OK);
    }

    @GetMapping("/getBySubject")
    ResponseEntity<?> getBySubject(@RequestParam(value = "mahocsinh", required = false) UUID mahocsinh,
                                   @RequestParam(value = "hocki", required = false) String ki,
                                   @RequestParam(value = "tenmon", required = false) String tenmon) {
        List<Diem> list = diemService.findByStudentIDAndSubject(mahocsinh, ki.equals("true") ? true : false, tenmon);
        List<DiemDTO> DiemDTOS = new ArrayList<>();
        list.forEach(x -> DiemDTOS.add(diemConvert.toDTO(x)));
        return new ResponseEntity<>(DiemDTOS, HttpStatus.OK);
    }

    @GetMapping("/getClass")
    ResponseEntity<?> getClass(@RequestParam(value = "mahocsinh", required = false) UUID mahocsinh) {
        List<lopResultDTO> list = diemService.findClass(mahocsinh);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getPoint")
    ResponseEntity<?> getPoint(@RequestParam(value = "mahocsinh", required = false) UUID mahocsinh,
                               @RequestParam(value = "tenlop", required = false) String tenlop) {
        List<diemCuoiNamDTO> diemhocki1 = diemService.findPoint(mahocsinh, tenlop, true);
        List<diemCuoiNamDTO> diemhocki2 = diemService.findPoint(mahocsinh, tenlop, false);
        List<diemCuoiNamResponse> diemCuoiNamResponse = new ArrayList<>();
        for (diemCuoiNamDTO diemCuoiNamDTO1 : diemhocki1) {
            for (diemCuoiNamDTO diemCuoiNamDTO2 : diemhocki2) {
                if (diemCuoiNamDTO1.getTenMon().equals(diemCuoiNamDTO2.getTenMon())) {
                    diemCuoiNamResponse data = new diemCuoiNamResponse();
                    data.setMahocsinh(diemCuoiNamDTO1.getMahocsinh());
                    data.setHoten(diemCuoiNamDTO1.getHoten());
                    data.setMon(diemCuoiNamDTO1.getTenMon());
                    data.setDiemhk1(diemCuoiNamDTO1.getDiemTBM());
                    data.setDiemhk2(diemCuoiNamDTO2.getDiemTBM());
                    data.setTbm((diemCuoiNamDTO1.getDiemTBM() + diemCuoiNamDTO2.getDiemTBM()) / 2);
                    diemCuoiNamResponse.add(data);
                }
            }
        }

        return new ResponseEntity<>(diemCuoiNamResponse, HttpStatus.OK);
    }

    @DeleteMapping("/diem")
    public void delete() {
        diemService.delete();
    }

    /* tuan anh export diem excel,pdf 26-11-2020 */

    //	/**
//	 * @author tuan_anh 12/2020
//	 * excel
//	 * @param mahocsinh
//	 * @param hocki
//	 * @param tenmon
//	 * @param response
//	 * @return
//	 */
    @GetMapping("/excel")
    ResponseEntity<?> exportToExcel(HttpServletResponse response, @RequestParam(value = "id", required = false) UUID id,
                                    @RequestParam(value = "hocki", required = false) String ki) throws IOException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Bang diem" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<Diem> list = diemService.findBymahocsinhAndKi(id, ki.equals("true") ? true : false);
        List<DiemDTO> DiemDTOS = new ArrayList<>();
        list.forEach(x -> DiemDTOS.add(diemConvert.toDTO(x)));
        DiemExcel excelExporter = new DiemExcel(DiemDTOS);
        excelExporter.export(response);
        return (ResponseEntity<?>) response;
    }

//	/**
//	 * @author tuan_anh 12/2020
//	 * pdf
//	 * @param mahocsinh
//	 * @param hocki
//	 * @param tenmon
//	 * @param response
//	 * @return
//	 */
//	@GetMapping("pdf")
//	ResponseEntity<?> exportToPDF(HttpServletResponse response,@RequestParam(value = "id", required = false) UUID id,
//			@RequestParam(value = "hocki", required = false) String ki )
//			throws DocumentException, IOException {
//		response.setContentType("application/pdf");
//		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//		String currentDateTime = dateFormatter.format(new Date());
//		String headerKey = "Content-Disposition";
//		String headerValue = "attachment; filename=Bang diem" + currentDateTime + ".pdf";
//		response.setHeader(headerKey, headerValue);
//		List<Diem> list = diemService.findBymahocsinhAndKi(id, ki.equals("true") ? true : false);
//		List<DiemDTO> DiemDTOS = new ArrayList<>();
//		list.forEach(x -> DiemDTOS.add(diemConvert.toDTO(x)));
//		DiemPDF exporter = new DiemPDF(DiemDTOS);
//		exporter.export(response);
//		return  (ResponseEntity<?>) response;
//	}

    @GetMapping("/hs/diemtbht/{id}")
    public ResponseEntity<?> diemtbht(@PathVariable UUID id) {
        float tongdiemki1 = 0, tongdiemki2 = 0;
        LopHoc lopHoc = lopHocService.findClassById(id);
        List<diemCuoiNamDTO> diemhocki1 = diemService.findPoint(id, lopHoc.getTenlop(), true);
        List<diemCuoiNamDTO> diemhocki2 = diemService.findPoint(id, lopHoc.getTenlop(), false);
        for (diemCuoiNamDTO dto : diemhocki1) {
            tongdiemki1 = tongdiemki1 + dto.getDiemTBM();
        }
        for (diemCuoiNamDTO hocki2 : diemhocki2) {
            tongdiemki2 = tongdiemki2 + hocki2.getDiemTBM();
        }
        float diemcuoinam = (tongdiemki1 / diemhocki1.size() + tongdiemki2 / diemhocki2.size()) / 2;
        diemTBHTResponse response = new diemTBHTResponse();
        response.setDiemtb(diemcuoinam);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/lichsuhoctap/{id}")
    public ResponseEntity<?> lichsuhoctap(@PathVariable UUID id) {
        float tongdiemki1 = 0, tongdiemki2 = 0;
        List<lopResultDTO> list = diemService.findClass(id);
        List<lichsuhoctap> dataresponse = new ArrayList<>();
        for (lopResultDTO lopResultDTO : list) {
            List<diemCuoiNamDTO> diemhocki1 = diemService.findPoint(id, lopResultDTO.getTenlop(), true);
            List<diemCuoiNamDTO> diemhocki2 = diemService.findPoint(id, lopResultDTO.getTenlop(), false);
            for (diemCuoiNamDTO dto : diemhocki1) {
                tongdiemki1 = tongdiemki1 + dto.getDiemTBM();
            }
            for (diemCuoiNamDTO hocki2 : diemhocki2) {
                tongdiemki2 = tongdiemki2 + hocki2.getDiemTBM();
            }
            lichsuhoctap data = new lichsuhoctap();
            data.setLophoc(lopResultDTO.getTenlop());
            data.setKi1(tongdiemki1/diemhocki1.size());
            data.setKi2(tongdiemki2/diemhocki2.size());
            dataresponse.add(data);
			tongdiemki1 = 0;
			tongdiemki2 = 0;
        }
        return new ResponseEntity<>(dataresponse, HttpStatus.OK);
    }

    @GetMapping("/dt/bieudo1")
    public ResponseEntity<?> hocluxtoantruong() {
        int sohocsinhgioi = 0;
        int sohocsinhkha = 0;
        int sohocsinhTB = 0;
        int sohocsinhyeu = 0;
        List<HocLucToanTruongResponse> dataresponse = new ArrayList<>();
        List<Khoi> khois = khoiService.findAll();
        for(Khoi khoi:khois){
            List<KetquaResponse> kqki1 = diemService.findketquaByKi(true, khoi.getMakhoi());
            List<KetquaResponse> kqki2 = diemService.findketquaByKi(false, khoi.getMakhoi());
            for (KetquaResponse ketquaResponse1 : kqki1) {
                for (KetquaResponse ketquaResponse2 : kqki2) {
                    if (ketquaResponse1.getMahocsinh().equals(ketquaResponse2.getMahocsinh())) {
                        float rate = (float) ((ketquaResponse1.getDientk()+ketquaResponse2.getDientk())/2);
                        if (rate >= 8) {
                            sohocsinhgioi++;
                        } else if (rate >= 7 && rate < 8) {
                            sohocsinhkha++;
                        } else if (rate >= 5 && rate < 7) {
                            sohocsinhTB++;
                        } else if (rate < 5) {
                            sohocsinhyeu++;
                        }
                    }
                }
            }
            HocLucToanTruongResponse data = new HocLucToanTruongResponse();
            data.setKhoi(khoi.getTenkhoi());
            data.setGioi(sohocsinhgioi);
            data.setKha(sohocsinhkha);
            data.setTrungbinh(sohocsinhTB);
            data.setYeu(sohocsinhyeu);
            dataresponse.add(data);
            sohocsinhgioi = 0;
            sohocsinhkha = 0;
            sohocsinhTB = 0;
            sohocsinhyeu = 0;
        }
        return new ResponseEntity<>(dataresponse, HttpStatus.OK);
    }
}
