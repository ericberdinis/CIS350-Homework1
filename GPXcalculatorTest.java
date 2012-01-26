import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import edu.upenn.cis350.gpx.*;

public class  GPXcalculatorTest {

	//////// Typical Inputs ////////
	@Test
	public void testLotsOfSegments() {

		GPXtrk t1 = new GPXtrk("lots of segments", new ArrayList<GPXtrkseg>(
						Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
							Arrays.asList(
								new GPXtrkpt(10, 20, new Date()),
								new GPXtrkpt(20, 21, new Date()),
								new GPXtrkpt(30, 22, new Date()),
								new GPXtrkpt(40, 23, new Date()),
								new GPXtrkpt(50, 24, new Date()),
								new GPXtrkpt(60, 25, new Date()),
								new GPXtrkpt(70, 26, new Date()),
								new GPXtrkpt(80, 27, new Date()),
								new GPXtrkpt(89, 28, new Date()),
								new GPXtrkpt(4, 29, new Date())							
							))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
							Arrays.asList(
								new GPXtrkpt(10, 20, new Date()),
								new GPXtrkpt(9, 30, new Date()),
								new GPXtrkpt(8, 40, new Date()),
								new GPXtrkpt(7, 50, new Date()),
								new GPXtrkpt(6, 60, new Date()),
								new GPXtrkpt(5, 70, new Date())						
							))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
							Arrays.asList(
								new GPXtrkpt(4, 80, new Date()),
								new GPXtrkpt(3, 60, new Date()),
								new GPXtrkpt(2, 52, new Date()),
								new GPXtrkpt(1, 34, new Date()),
								new GPXtrkpt(89, 56, new Date()),
								new GPXtrkpt(88, 78, new Date()),
								new GPXtrkpt(87, 89, new Date()),
								new GPXtrkpt(86, 54, new Date()),
								new GPXtrkpt(85, 43, new Date()),
								new GPXtrkpt(84, 32, new Date())						
							))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
							Arrays.asList(
								new GPXtrkpt(40, 23, new Date()),
								new GPXtrkpt(50, 24, new Date()),
								new GPXtrkpt(10, 20, new Date()),
								new GPXtrkpt(1, 34, new Date()),
								new GPXtrkpt(89, 56, new Date()),
								new GPXtrkpt(88, 78, new Date()),
								new GPXtrkpt(10, 20, new Date()),
								new GPXtrkpt(80, 27, new Date()),
								new GPXtrkpt(89, 28, new Date()),
								new GPXtrkpt(9, 30, new Date()),
								new GPXtrkpt(8, 40, new Date())							
							))))));
		
		assertEquals(887.9601220575290000, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	public void testOneSegment(){
		GPXtrk t1 = new GPXtrk("one segment", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
							new GPXtrkpt(40, 23, new Date()),
							new GPXtrkpt(50, 24, new Date()),
							new GPXtrkpt(10, 20, new Date()),
							new GPXtrkpt(1, 34, new Date()),
							new GPXtrkpt(89, 56, new Date()),
							new GPXtrkpt(88, 78, new Date()),
							new GPXtrkpt(10, 20, new Date()),
							new GPXtrkpt(80, 27, new Date()),
							new GPXtrkpt(89, 28, new Date()),
							new GPXtrkpt(9, 30, new Date()),
							new GPXtrkpt(8, 40, new Date())							
					))))));
		
		assertEquals(446.3039436, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);

	}
	
	public void testTwoPoints(){
		GPXtrk t1 = new GPXtrk("two points", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
							new GPXtrkpt(40, 23, new Date()),
							new GPXtrkpt(50, 24, new Date())
					))))));
		
		assertEquals(10.04987562, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);

	}
	
	
	//////// Null Inputs ///////
	
	@Test
	public void testNullTrack(){
		assertEquals(-1, GPXcalculator.calculateDistanceTraveled(null), 0.0001);
	}
	
	@Test
	public void testOneNullSeg(){
		ArrayList<GPXtrkseg> seg = new ArrayList<GPXtrkseg>();
		seg.add(null);
		seg.add(new GPXtrkseg(new ArrayList<GPXtrkpt>(
				Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())							
				))));
		GPXtrk t1 = new GPXtrk("multiple null segments", seg);
		assertEquals(0, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testOnlyNullSeg(){
		ArrayList<GPXtrkseg> t1 = new ArrayList<GPXtrkseg>();
		t1.add(null);
		GPXtrk track = new GPXtrk("only a null segment", t1);
		assertEquals(0, GPXcalculator.calculateDistanceTraveled(track), 0.0001);
	}
	
	@Test
	public void testMultNullSeg(){
		
		ArrayList<GPXtrkseg> seg = new ArrayList<GPXtrkseg>();
		seg.add(null);
		seg.add(new GPXtrkseg(new ArrayList<GPXtrkpt>(
				Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())							
				))));
		seg.add(null);
		GPXtrk t1 = new GPXtrk("multiple null segments", seg);
		assertEquals(0, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testOneNullPoint(){
		GPXtrk t1 = new GPXtrk("one null point", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
							new GPXtrkpt(40, 23, new Date()),
							new GPXtrkpt(50, 24, new Date()),
							new GPXtrkpt(10, 20, new Date()),
							new GPXtrkpt(1, 34, new Date()),
							null,
							new GPXtrkpt(89, 56, new Date()),
							new GPXtrkpt(88, 78, new Date()),
							new GPXtrkpt(10, 20, new Date()),
							new GPXtrkpt(80, 27, new Date()),
							new GPXtrkpt(89, 28, new Date()),
							new GPXtrkpt(9, 30, new Date()),
							new GPXtrkpt(8, 40, new Date())							
					))))));
		
		assertEquals(0, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testMultNullPoints(){
		GPXtrk t1 = new GPXtrk("multiple null points", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(30, 22, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						null,
						new GPXtrkpt(8, 40, new Date()),
						new GPXtrkpt(7, 50, new Date()),
						new GPXtrkpt(6, 60, new Date()),
						null,
						new GPXtrkpt(5, 70, new Date())						
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(4, 80, new Date()),
						new GPXtrkpt(3, 60, new Date()),
						new GPXtrkpt(2, 52, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(87, 89, new Date()),
						null,
						new GPXtrkpt(86, 54, new Date()),
						new GPXtrkpt(85, 43, new Date()),
						new GPXtrkpt(84, 32, new Date())						
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())							
					))))));

		assertEquals(610.7143403, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testOnlyNullPoints(){
		ArrayList<GPXtrkpt> s = new ArrayList<GPXtrkpt>();
		s.add(null);
		s.add(null);
		s.add(null);
		s.add(null);
		s.add(null);
		GPXtrkseg seg = new GPXtrkseg(s);
		ArrayList<GPXtrkseg> t = new ArrayList<GPXtrkseg>();
		t.add(seg);
		GPXtrk track = new GPXtrk("only null points", t);
		
		assertEquals(0, GPXcalculator.calculateDistanceTraveled(track), 0.0001);
	}
	
	////////// Empty Inputs //////////
	@Test
	public void testEmptyTrack() {
		GPXtrk t1 = new GPXtrk("no segments", new ArrayList<GPXtrkseg>());
		assertEquals(-1, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testOneEmptySeg() {
		GPXtrk t1 = new GPXtrk("one empty segment", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(30, 22, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					)), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())							
					))))));

		assertEquals(610.7143403, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testAllEmptySegs() {
		GPXtrk t1 = new GPXtrk("one empty segment", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					)), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					)), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					)))));

		assertEquals(446.3039436, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	
	/////////// Boundary Cases ///////////
	
	@Test
	public void testOnePoint() {
		GPXtrk t1 = new GPXtrk("two points", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
							new GPXtrkpt(40, 23, new Date())
					))))));
		
		assertEquals(0, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testOnePointMultSeg() {
		GPXtrk t1 = new GPXtrk("multiple segments with one point", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date())			
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date())						
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(4, 80, new Date())						
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())							
					))))));

assertEquals(446.3039436, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testLatGreater90() {
		GPXtrk t1 = new GPXtrk("latitude > 90", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(91, 22, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())						
					))))));
		
		assertEquals(446.3039436, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testLatWayGreater90() {
		GPXtrk t1 = new GPXtrk("latitude >> 90", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(1000, 22, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())						
					))))));
		
		assertEquals(446.3039436, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testLat90() {
		GPXtrk t1 = new GPXtrk("latitude = 90", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(90, 22, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())						
					))))));
		
		assertEquals(710.6317305, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testLatLessNeg90() {
		GPXtrk t1 = new GPXtrk("latitude < -90", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(-91, 22, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())						
					))))));
		
		assertEquals(446.3039436, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testLatWayLessNeg90() {
		GPXtrk t1 = new GPXtrk("latitude << -90", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(-1000, 22, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())						
					))))));
		
		assertEquals(446.3039436, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testLatNeg90() {
		GPXtrk t1 = new GPXtrk("latitude = -90", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(-90, 22, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())						
					))))));
		
		assertEquals(830.6229805, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testLongGreater180() {
		GPXtrk t1 = new GPXtrk("longitude > 180", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(30, 181, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())						
					))))));
		
		assertEquals(446.3039436, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testLongWayGreater180() {
		GPXtrk t1 = new GPXtrk("longitude >> 180", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(30, 1000, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())						
					))))));
		
		assertEquals(446.3039436, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testLong180() {
		GPXtrk t1 = new GPXtrk("longitude = 180", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(30, 180, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())						
					))))));
		
		assertEquals(907.2468931, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testLongLessNeg180() {
		GPXtrk t1 = new GPXtrk("longitude < -180", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(30, -181, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())						
					))))));
		
		assertEquals(446.3039436, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testLongWayLessNeg180() {
		GPXtrk t1 = new GPXtrk("longitude << -180", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(30, -1000, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())						
					))))));
		
		assertEquals(446.3039436, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
	
	@Test
	public void testLongNeg180() {
		GPXtrk t1 = new GPXtrk("longitude = -180", new ArrayList<GPXtrkseg>(
				Arrays.asList(new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(20, 21, new Date()),
						new GPXtrkpt(30, -180, new Date()),
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(60, 25, new Date()),
						new GPXtrkpt(70, 26, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(4, 29, new Date())							
					))), new GPXtrkseg(new ArrayList<GPXtrkpt>(
					Arrays.asList(
						new GPXtrkpt(40, 23, new Date()),
						new GPXtrkpt(50, 24, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(1, 34, new Date()),
						new GPXtrkpt(89, 56, new Date()),
						new GPXtrkpt(88, 78, new Date()),
						new GPXtrkpt(10, 20, new Date()),
						new GPXtrkpt(80, 27, new Date()),
						new GPXtrkpt(89, 28, new Date()),
						new GPXtrkpt(9, 30, new Date()),
						new GPXtrkpt(8, 40, new Date())						
					))))));
		
		assertEquals(995.1093477, GPXcalculator.calculateDistanceTraveled(t1), 0.0001);
	}
}
