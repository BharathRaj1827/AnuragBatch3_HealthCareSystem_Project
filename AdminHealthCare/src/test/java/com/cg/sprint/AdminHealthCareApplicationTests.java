package com.cg.sprint;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.sprint.dao.AdminRepository;
import com.cg.sprint.dao.AppointmentRepository;
import com.cg.sprint.dao.Diagnostic_centerRepository;
import com.cg.sprint.dao.TestclassRepository;
import com.cg.sprint.dto.Appointment;
import com.cg.sprint.dto.Diagnostic_center;
import com.cg.sprint.dto.Testclass;
import com.cg.sprint.service.AdminServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class AdminHealthCareApplicationTests {
	@Mock
	private AdminRepository ar;
	@Mock
	private Diagnostic_centerRepository cr;
	@Mock
	private TestclassRepository tr;
	@Mock
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
		centerList.add(new Diagnostic_center("1","hyderabad",1234567890L,"nacharam"));
		centerList.add(new Diagnostic_center("2","secunderabad",9999999990L,"prakashnagar"));
		centerList.add(new Diagnostic_center( "3","nagole",1234567834L,"suryanagar"));
		when(cr.findAll()).thenReturn(centerList);
		List<Diagnostic_center> result = adminService.viewDiagnostic_center();
		assertEquals(3, result.size());
	}
	
	
	
	@Test
	public void addCenter(){
		Diagnostic_center center = new Diagnostic_center("4","ameerpet",1234567880L,"punjagutta" );
		adminService.addCenter(center);
		Mockito.verify(cr,Mockito.times(1)).save(center);
	}
		
	
	
	@Test
	public void removeCenter(){
		Diagnostic_center centreid = new Diagnostic_center("4","ameerpet",1235467890L,"punjagutta");
		cr.deleteById(4);
		cr.save(centreid);
		verify(cr,Mockito.times(1)).save(centreid);
	}
	
	@Test
	public void testviewTestClass(){
		List<Testclass> testList = new ArrayList<Testclass>();
		testList.add(new Testclass("1","bloodtest","1"));
		testList.add(new Testclass("2","bp","3"));
		testList.add(new Testclass("3","sugar","2"));
		when(tr.findAll()).thenReturn(testList);
		
		List<Testclass> result = adminService.viewTestclass();
		assertEquals(3, result.size());
	}
	
	@Test
	public void addTestclass(){
		Testclass testclass = new Testclass("4","dengue","3");
		adminService.addTestclass(testclass);
		verify(tr,times(1)).save(testclass);
	}
	
	
	@Test
	public void removeTestclass(){
		Testclass testid = new Testclass("4","dengue","3");
		tr.deleteById(4);
		tr.save(testid);
		verify(tr,Mockito.times(1)).deleteById(4);
	}
	

	@Test
	
	public void testviewAppointment1()throws java.text.ParseException{
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		
		appointmentList.add(new Appointment(1,false,"2020-05-31","1","bp","1"));
		
		appointmentList.add(new Appointment(2,false,"2020-05-31","1","bpt","2"));
	
		appointmentList.add(new Appointment(3,false,"2020-05-31","2","bpte","3"));
		
		Mockito.when(ap.findAllById(3)).thenReturn(appointmentList);
		
		List<Appointment> returnedData = ap.findAllById(3);
		assertEquals(3,returnedData.size());
	}
	
	
	@Test
	public void testviewAppointment2() throws java.text.ParseException{
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		
		appointmentList.add(new Appointment(1,false,"2020-05-31","1","bp","1"));
		
		
		appointmentList.add(new Appointment(2,false,"2020-05-31","1","bpt","2"));
		
		appointmentList.add(new Appointment(3,false,"2020-05-31","2","bpte","3"));
		when(ap.findAll()).thenReturn(appointmentList);
		
		List<Appointment> result = adminService.viewAppointment2();
		assertEquals(3, result.size());
	}
	
	
			
	@Test
	public void updateAppointment() throws java.text.ParseException{
		Appointment a = new Appointment(4,false,"2020-05-31","1","bp","1");
		ap.findById(4);
		ap.save(a);
		verify(ap,Mockito.times(1)).save(a);
	}
}



