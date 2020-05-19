package com.cg.sprint;
import static org.junit.Assert.assertEquals;
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

import com.cg.sprint.dao.AppointmentRepository;
import com.cg.sprint.dao.Diagnostic_centerRepository;
import com.cg.sprint.dao.TestclassRepository;
import com.cg.sprint.dao.UserRepository;
import com.cg.sprint.dto.Appointment;
import com.cg.sprint.dto.Diagnostic_center;
import com.cg.sprint.dto.Testclass;
import com.cg.sprint.dto.Users;
import com.cg.sprint.service.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class UserHealthCareApplicationTests {

	    @Mock
		private UserRepository ur;
		@Mock
		private Diagnostic_centerRepository cr;
		@Mock
		private TestclassRepository tr;
		@Mock
		private AppointmentRepository ap;
		
		
		@InjectMocks
		private UserServiceImpl userService;
		
		@Before
		public void setup(){
			MockitoAnnotations.initMocks(this);
		}
		
		@Test
		public void testviewTestclass(){
			List<Testclass> testList = new ArrayList<Testclass>();
			testList.add(new Testclass("1","bloodtest","1"));
			testList.add(new Testclass("2","bp","3"));
			testList.add(new Testclass("3","sugar","2"));
			when(tr.findAll()).thenReturn(testList);
			
			List<Testclass> result = userService.viewTestclass("3");
			assertEquals("3", result.size());
		}
		
		
		
		
		@Test
		public void addUser(){
			Users user = new Users("1","monika",20,"female",9000000000L,"abcde","moni@gmail.com");
			userService.addUser(user);
			Mockito.verify(ur,Mockito.times(1)).save(user);
		}
		
		@Test
		public void addAppointment() throws java.text.ParseException{
			Appointment appointment = new Appointment(1,false,"2020-05-31","1","bp","1");
			userService.makeAppointment(appointment);
			Mockito.verify(ap,Mockito.times(1)).save(appointment);
		}
			
		@Test
		public void viewAppointment() throws java.text.ParseException{
		    Appointment appointmentid = new Appointment(1,false,"2020-05-31","1","bp","1");
		    
		    ap.findById(1);
		    ap.save(appointmentid);
		    verify(ap,Mockito.times(1)).save(appointmentid);
		}
		
		@Test
		public void testviewDiagnostic_center(){
			List<Diagnostic_center> centerList = new ArrayList<Diagnostic_center>();
			centerList.add(new Diagnostic_center("1","hyderabad",123456789L,"nacharam"));
			centerList.add(new Diagnostic_center("2","secunderabad",345678902L,"prakashnagar"));
			centerList.add(new Diagnostic_center("3","ameerpet",123456783L,"punjagutta"));
			when(cr.findAll()).thenReturn(centerList);
			
			List<Diagnostic_center> result = userService.viewDiagnostic_centers();
			assertEquals(3, result.size());
		}
	

}
