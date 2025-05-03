package practica.invoicemocked;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class InvoiceFilterTest {
    @Test
    void filterInvoices() {
        Invoice mauricio = new Invoice("Mauricio", 20.0);
        Invoice arie = new Invoice("Arie", 300.0);

        InvoiceDao dao = mock(InvoiceDao.class);

        List<Invoice> results = Arrays.asList(mauricio, arie);
        when(dao.all()).thenReturn(results);

        InvoiceFilter filter = new InvoiceFilter(dao);
        List<Invoice> result = filter.filter();

        assertEquals(mauricio, result.get(0));
        assertEquals(1, result.size());
    }
    // Lista Vacia
    @Test
    void filterInvoices_EmptyList_ReturnsEmptyList() {
        InvoiceDao dao = mock(InvoiceDao.class);
        when(dao.all()).thenReturn(List.of());

        InvoiceFilter filter = new InvoiceFilter(dao);
        List<Invoice> result = filter.filter();

        assertTrue(result.isEmpty());
    }
    // Multiples facturas validas e invalidas
    @Test
    void filterInvoices_MultipleInvoices_ReturnsOnlyValidOnes() {
        // Configurar mock
        Invoice inv1 = new Invoice("A", 20.0);   // Válida
        Invoice inv2 = new Invoice("B", 300.0);  // Inválida
        Invoice inv3 = new Invoice("C", 99.0);   // Válida
        InvoiceDao dao = mock(InvoiceDao.class);
        when(dao.all()).thenReturn(Arrays.asList(inv1, inv2, inv3));

        // Ejecutar
        InvoiceFilter filter = new InvoiceFilter(dao);
        List<Invoice> result = filter.filter();

        // Verificar
        assertEquals(2, result.size());
        assertTrue(result.contains(inv1) && result.contains(inv3));
        verify(dao).all();
    }
    //Valor exactamente 100
    @Test
    void filterInvoices_InvoiceValue100_ExcludesIt() {
        Invoice inv = new Invoice("A", 100.0); // Valor límite
        InvoiceDao dao = mock(InvoiceDao.class);
        when(dao.all()).thenReturn(List.of(inv));

        InvoiceFilter filter = new InvoiceFilter(dao);
        List<Invoice> result = filter.filter();

        assertTrue(result.isEmpty()); // 100 no es menor que 100
    }
    //Valores negativos
    @Test
    void filterInvoices_NegativeValue_IncludesIt() {
        Invoice inv = new Invoice("A", -50.0); // Valor negativo
        InvoiceDao dao = mock(InvoiceDao.class);
        when(dao.all()).thenReturn(List.of(inv));

        InvoiceFilter filter = new InvoiceFilter(dao);
        List<Invoice> result = filter.filter();

        assertEquals(1, result.size()); // -50 < 100
    }
    //Mismo cliente pero valores diferentes
    @Test
    void filterInvoices_SameCustomerDifferentValues_FiltersCorrectly() {
        Invoice inv1 = new Invoice("A", 50.0);  // Válida
        Invoice inv2 = new Invoice("A", 150.0); // Inválida
        InvoiceDao dao = mock(InvoiceDao.class);
        when(dao.all()).thenReturn(Arrays.asList(inv1, inv2));

        InvoiceFilter filter = new InvoiceFilter(dao);
        List<Invoice> result = filter.filter();

        assertEquals(1, result.size());
        assertEquals(inv1, result.get(0));
    }
}