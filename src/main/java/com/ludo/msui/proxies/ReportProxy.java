package com.ludo.msui.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "msreport", url = "${ms_report.url}:9093")
public interface ReportProxy {

    @RequestMapping("/report/patient/{id}")
    String getReportByPatient(@PathVariable int id);

}
