package com.cg.sprint.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.bean.Admins;
import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Testclass;

import com.cg.dao.AdminRepository;
import com.cg.dao.AppointmentRepository;
import com.cg.dao.Diagnostic_centerRepository;
import com.cg.dao.TestclassRepository;
import com.cg.service.AdminServiceImpl;

import net.minidev.json.parser.ParseException;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdminServiceTest {
	@Mock
	private AdminRepository ar;
	private Diagnostic_centerRepository cr;
	private TestclassRepository tr;
	private AppointmentRepository ap;
	
	
	
	@InjectMocks
	private AdminServiceImpl adminService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	@Test
	public void testviewDiagnostic_center(){
		List<Diagnostic_center> centerList = new ArrayList<Diagnostic_center>();
		centerList.add(new Diagnostic_center(1,"hyd",123456789,"nac"));
		centerList.add(new Diagnostic_center(2,"nagole",999999999,"upl"));
		centerList.add(new Diagnostic_center( 3,"hh",1234567834,"ug"));
		
		
		when(cr.findAll()).thenReturn(centerList);
		List<Diagnostic_center> result = adminService.viewDiagnostic_center();
		assertEquals(3, result.size());
	}
	@Test
	public void addCenter(){
		Diagnostic_center center = new Diagnostic_center(4,"begum",1235467890L,"nach");
		
		/*adminService.addCenter(center);
		verify(cr,times(1)).save(center);
	}*/
	
		when(cr.save(center)).thenReturn(center);
		Diagnostic_center result = adminService.addCenter(center);
		assertEquals(4, result.getCentreid());
		assertEquals("begum", result.getCentrename());
		assertEquals(1234567890L, result.getCentrePhno());
		assertEquals("nac", result.getCentreAdd());
	}
	
	
	@Test
	public void removeCenter(){
		Diagnostic_center centerid = new Diagnostic_center(4,"begum",1235467890L,"nach");
		adminService.removeCenter(4);
        verify(cr, times(1)).delete(centerid);
	}
	
	
	@Test
	public void testviewTestClass(){
		List<Testclass> testList = new ArrayList<Testclass>();
		testList.add(new Testclass(1,"Tt",1234567890));
		testList.add(new Testclass(2,"bp",1234567898));
		testList.add(new Testclass(3,"sugar",2134567890));
		when(tr.findAll()).thenReturn(testList);
		
		List<Testclass> result = adminService.viewTestclass();
		assertEquals(3, result.size());
	}
	
	
	
	@Test
	public void addTestclass(){
		Testclass testclass = new Testclass(4,"dengue",1);
		/*adminService.addTestclass(testclass);
		verify(tr,times(1)).save(testclass);
	}
		*/
		when(tr.save(testclass)).thenReturn(testclass);
		Testclass result = adminService.addTestclass(testclass);
		assertEquals(4, result.getTestid());
		assertEquals("dengue", result.getTestname());
		assertEquals(1234567890, result.getCentrenum());
	}
	
	@Test
	public void removeTestclass(){
		Testclass testid = new Testclass(4,"dengue",1);
		adminService.removeTestclass(4);
        verify(tr, times(1)).deleteById(4);
	}
	

	@Test
	public void testviewAppointment1() throws java.text.ParseException{
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyy-MM-dd");
		try{
			Date d = sdf1.parse("2020-04-01");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		appointmentList.add(new Appointment(1,"Appointment Sample 1" ,sdf1 ,1234567819,"kk"));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyy-MM-dd");
		try{
			Date d = sdf2.parse("2020-04-02");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		appointmentList.add(new Appointment(2,"Appointment Sample 2",sdf2,1345678902,"pp"));
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyy-MM-dd");
		try{
			Date d = sdf3.parse("2020-04-03");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		appointmentList.add(new Appointment(3,"Appointment Sample 3",sdf3,1345267890,"hh"));
		when(ap.findAllById(3)).thenReturn(appointmentList);
		
		List<Appointment> result = adminService.viewAppointment1(1345267890);
		assertEquals(2, result.size());
	}
	
	
	@Test
	public void testviewAppointment2() throws java.text.ParseException{
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyy-MM-dd");
		Date d1 = sdf1.parse("2020-04-04");
		appointmentList.add(new Appointment(1,"Appointment Status1",sdf1,1235467890,"bp"));
		
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyy-MM-dd");
		Date d2 = sdf2.parse("2020-04-05");
		appointmentList.add(new Appointment(2,"Appointment Status2",sdf2,1235468790,"sugar"));
		
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyy-MM-dd");
		Date d3 = sdf3.parse("2020-04-06");
		appointmentList.add(new Appointment(3,"Appointment Status3",sdf3,1235467980,"hh"));
		when(ap.findAll()).thenReturn(appointmentList);
		
		List<Appointment> result = adminService.viewAppointment2();
		assertEquals(2, result.size());
	}
	
	
	@Test
	public void updateAppointment() throws java.text.ParseException{
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyy-MM-dd");
		Date d = sdf4.parse("2020-04-07");
		Appointment a = new Appointment(4,"Appointment Status4",sdf4,1345678900,"jj");
		adminService.updateAppointment(a);
        verify(ap, times(1)).save(a);
	//}
//}


		
		List<Appointment> result = adminService.viewAppointment2();
		assertEquals(2, result.size());
	}
	
	
	/*@Test
	public void updateAppointment(){
		Appointment a = new Appointment(4,"Appointment Status4",datetime,1345678900,"jj");
		adminService.updateAppointment(a);
        verify(ap, times(1)).save(a);
	}
*/
	}
