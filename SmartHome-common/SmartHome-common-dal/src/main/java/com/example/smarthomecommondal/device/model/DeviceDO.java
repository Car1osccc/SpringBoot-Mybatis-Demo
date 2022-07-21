package com.example.smarthomecommondal.device.model;

import lombok.Data;

/**
 * @author Yihan Chen
 * @date 2022/7/13 14:11
 */
@Data
public class DeviceDO {
    /**
     * 设备ID
     */
    private String DeviceID;
    /**
     * 设备
     */
    private String DeviceName;
    private String DeviceInfo;
    private String Family_FamilyID;
    private String Category_CategoryID;
    private String Manufacturer_ManufacturerID;
    private String DeviceDeleteFlag;
}
