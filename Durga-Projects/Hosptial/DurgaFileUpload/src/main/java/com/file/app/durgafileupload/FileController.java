package com.file.app.durgafileupload;

import com.file.app.durgafileupload.entity.AppiontmentDetails;
import com.file.app.durgafileupload.entity.BookBedInformation;
import com.file.app.durgafileupload.entity.ICUBeds;
import com.file.app.durgafileupload.service.AppiontmentDetailsServiceImpl;
import com.file.app.durgafileupload.service.BookBedInformationImpl;
import com.file.app.durgafileupload.service.ICUBedsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;
import java.util.List;

@Controller
public class FileController {

    @Autowired
    private ICUBedsServiceImpl service;

    @Autowired
    private BookBedInformationImpl bedInformation;

    @Autowired
    private AppiontmentDetailsServiceImpl appiontmentDetailsService;

    @GetMapping("/home")
    public String showHomePage() {
        return "home-page";
    }

    @GetMapping("/bookbed")
    public ModelAndView showBedsAvailablePage() {
        ModelAndView model = new ModelAndView();
        List<ICUBeds> allBedsList = service.getAllIcuBeds();
        List avalaibleBeds =  allBedsList.stream().filter(icuBeds -> icuBeds.getIsAvalable().equals("true")).collect(Collectors.toList());
        List bookedBeds =  allBedsList.stream().filter(icuBeds -> icuBeds.getIsBooked().equals("true")).collect(Collectors.toList());
        model.addObject("avalaibleBeds", avalaibleBeds.size());
        model.addObject("bookedBeds", bookedBeds.size());
        model.setViewName("book-bed");
        return model;
    }

    @PostMapping("/savebeds")
    ResponseEntity<?> createBeds(@RequestBody ICUBeds icuBeds) {
        service.createBed(icuBeds);
        return new ResponseEntity<>("Bed Created SuccessFully...!", HttpStatus.OK);
    }

    @PostMapping("/book-bed")
    ModelAndView saveBookingInformation(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        BookBedInformation information = new BookBedInformation();
        information.setPatientName(request.getParameter("personname"));
        information.setPatientAge(request.getParameter("personage"));
        information.setPatientAddr(request.getParameter("personaddr"));
        information.setPatientGender(request.getParameter("persongen"));
        information.setRoomNum(request.getParameter("roomnumber"));
        information.setBedNum(request.getParameter("bednumber"));
        ICUBeds icuBeds = service.getIcuBedById(Integer.parseInt(request.getParameter("bednumber")));
        if (icuBeds != null) {
            icuBeds.setIsAvalable("false");
            icuBeds.setIsBooked("true");
        }
        service.createBed(icuBeds);
        bedInformation.saveBookingInfo(information);
        model.addObject("bookSuccessObj", "Bed Booked Successfully...!");
        model.setViewName("book-bed");
        return model;
    }

    @GetMapping("/getBookedInfo")
    public ModelAndView getBookInformation() {
        ModelAndView model = new ModelAndView();
        List<BookBedInformation> bedInformations = bedInformation.listBookBedInformations();
        model.addObject("bedInformations", bedInformations);
        List<ICUBeds> allBedsList = service.getAllIcuBeds();
        List avalaibleBeds =  allBedsList.stream().filter(icuBeds -> icuBeds.getIsAvalable().equals("true")).collect(Collectors.toList());
        List bookedBeds =  allBedsList.stream().filter(icuBeds -> icuBeds.getIsBooked().equals("true")).collect(Collectors.toList());
        model.addObject("avalaibleBeds", avalaibleBeds.size());
        model.addObject("bookedBeds", bookedBeds.size());
        model.setViewName("booked-info");
        return model;
    }

    @GetMapping("/e-appointment")
    public ModelAndView showEDoctorAppointment() {
        ModelAndView model = new ModelAndView();
        model.setViewName("e-appointment");
        return model;
    }

    @PostMapping("/book-appointment")
    public ModelAndView saveAppointmentDetails(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        AppiontmentDetails details = new AppiontmentDetails();
        details.setPatientName(request.getParameter("personname"));
        details.setPatentAge(request.getParameter("personage"));
        details.setAppintMentDate(request.getParameter("date"));
        details.setProblem(request.getParameter("problem"));
        appiontmentDetailsService.saveAppiontmentDetails(details);
        model.addObject("saveObj","Appointment Details Saved Successfully...!");
        model.setViewName("e-appointment");
        return model;
    }

    @GetMapping("/appiontmentDetails")
    public ModelAndView getAppointDetails() {
        ModelAndView model = new ModelAndView();
        List<AppiontmentDetails> appiontmentDetails =  appiontmentDetailsService.listAllAppointDetails();
        model.addObject("appiontmentDetails", appiontmentDetails);
        model.setViewName("appiontmentDetails");
        return model;
    }

    @GetMapping("/show-oxigendetails")
   public  String getOxigenDetails() {
        return "oxigendetails";
    }
}
