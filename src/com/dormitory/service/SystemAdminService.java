package com.dormitory.service;

import com.dormitory.dto.SystemAdminDto;

public interface SystemAdminService {
    public SystemAdminDto login(String username,String password);
}
