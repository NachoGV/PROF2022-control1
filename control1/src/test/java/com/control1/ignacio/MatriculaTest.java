package com.control1.ignacio;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class MatriculaTest {

    @Test
    public void testVectorNulo() {
        Matricula mat = new Matricula(null);

        boolean thrown = false;

        try {

            mat.getImporte();

        } catch (Exception e) {

            thrown = true;

        }

        assertTrue(thrown);
    }   

    @Test
    public void importeCorrecto() {
        Matricula mat = mock(Matricula.class);

        Asignatura asig1 = mock(Asignatura.class);
        Asignatura asig2 = mock(Asignatura.class);
        Asignatura asig3 = mock(Asignatura.class);

        when(asig1.getImporte()).thenReturn(100.0);
        when(asig2.getImporte()).thenReturn(200.0);
        when(asig3.getImporte()).thenReturn(300.0);

        mat.vectorAsignaturas.add(asig1);
        mat.vectorAsignaturas.add(asig2);
        mat.vectorAsignaturas.add(asig3);

        try {
            assertTrue(mat.getImporte() == 600.0);
        } catch (Exception e) {
            fail("Exception al calcular el importe");
        }
    }

    @Test
    public void recorreAsignaturas() {
        Matricula mat = mock(Matricula.class);

        Asignatura asig1 = mock(Asignatura.class);
        Asignatura asig2 = mock(Asignatura.class);
        Asignatura asig3 = mock(Asignatura.class);

        when(asig1.getImporte()).thenReturn(100.0);
        when(asig2.getImporte()).thenReturn(200.0);
        when(asig3.getImporte()).thenReturn(300.0);

        mat.vectorAsignaturas.add(asig1);
        mat.vectorAsignaturas.add(asig2);
        mat.vectorAsignaturas.add(asig3);

        try {
            mat.getImporte();
        } catch (Exception e) {
            fail("Exception al calcular el importe");
        }

        verify(asig1, times(1)).getImporte();
        verify(asig2, times(1)).getImporte();
        verify(asig3, times(1)).getImporte();
    }

}
