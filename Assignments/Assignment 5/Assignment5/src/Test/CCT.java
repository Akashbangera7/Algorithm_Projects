package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Coupon_Collector;



class CCT {

	@Test
	public void hash1() throws Exception {

	       int[] xs = {3,4,2,1};
	       Coupon_Collector.x=4;
	       Coupon_Collector.array = new int[4];
	       Coupon_Collector.hashtest(xs);
	       assertEquals(Coupon_Collector.array[0], 4);
	       assertEquals(Coupon_Collector.array[1], 1);
	       assertEquals(Coupon_Collector.array[2], 2);
	       assertEquals(Coupon_Collector.array[3], 3);
	   }

	
	@Test
	public void hash2() throws Exception {

	       int[] xs = {18,20,24,25,21};
	       Coupon_Collector.array = new int[5];
	       Coupon_Collector.x=5;
	       Coupon_Collector.hashtest(xs);
	       assertEquals(Coupon_Collector.array[0],25);
	       assertEquals(Coupon_Collector.array[1], 21);
	       assertEquals(Coupon_Collector.array[2], 0);
	       assertEquals(Coupon_Collector.array[3], 18);
	       assertEquals(Coupon_Collector.array[4], 24);
	       
	   }
}
