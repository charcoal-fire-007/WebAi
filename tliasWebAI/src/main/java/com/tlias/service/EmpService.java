package com.tlias.service;

import com.tlias.pojo.EmpQueryParam;
import com.tlias.pojo.PagesResult;

public interface EmpService {

    PagesResult List(EmpQueryParam empQueryParam);
}
