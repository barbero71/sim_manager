package org.barberini.sim_manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SimManagerApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Test
	public void myFirstTest()
	{
		assertEquals(2,1+1);
	}

}
