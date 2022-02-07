package com.ludo.msui.service;

import com.ludo.msui.proxies.ReportProxy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportServiceProxyImplTest {

    @Mock
    private ReportProxy mockReportProxy;

    @InjectMocks
    private ReportServiceProxyImpl reportServiceProxyImplUnderTest;

    @Test
    void testGetReport() {
        when(mockReportProxy.getReportByPatient(0)).thenReturn("result");

        final String result = reportServiceProxyImplUnderTest.getReport(0);

        assertThat(result).isEqualTo("result");
    }
}
