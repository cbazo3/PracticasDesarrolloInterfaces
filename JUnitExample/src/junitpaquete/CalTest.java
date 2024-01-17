package junitpaquete;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalTest {
 private Cal c = new Cal();
 @Test
 void testAdd() {
 assertEquals(5, c.add(2, 3));
 }
 @Test
 void testSubstract() {
 assertEquals(-1, c.substract(2, 3));
 }
 @Test
 void testMultiplicar() {
     assertEquals(6, c.multiplicar(2, 3));
 }

 @Test
 void testDividir() {
     assertEquals(2, c.dividir(6, 3));
 }

 @Test
 void testDividirPorCero() {
     assertThrows(IllegalArgumentException.class, () -> c.dividir(6, 0));
 }

 @Test
 void testModulo() {
     assertEquals(2, c.modulo(7, 5));
 }

 @Test
 void testModuloPorCero() {
     assertThrows(IllegalArgumentException.class, () -> c.modulo(7, 0));
 }
}