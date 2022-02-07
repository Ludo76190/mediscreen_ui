package com.ludo.msui.service;

import com.ludo.msui.proxies.ReportProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceProxyImpl implements ReportProxyService{

    @Autowired
    private ReportProxy reportProxy;

    @Override
    public String getReport(int patientId) {

        return reportProxy.getReportByPatient(patientId);
    }
}
