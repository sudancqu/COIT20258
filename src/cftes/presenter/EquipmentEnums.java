/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cftes.presenter;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public enum EquipmentEnums {
    desktop_screen,
    laptop_screen,
    desktop_2screens,
    laptop_office_home,
    desktop_screen_laptop;

    @Override
    public String toString() {
         switch(this) {
            case desktop_screen:
                return "Desktop* + screen";
            case laptop_screen:
                return "Laptop + screen";
            case desktop_2screens:
                return "Desktop + 2 screens";
            case laptop_office_home:
                return "Laptop* + screen at office + screen at home";
            case desktop_screen_laptop:
                return "Desktop + screen + laptop";
            default:
                return "";
        }
    }
    
    public static EquipmentEnums fromString(String str) {
        switch(str) {
            case "Desktop* + screen":
                return EquipmentEnums.desktop_screen;
            case "Laptop + screen":
                return EquipmentEnums.laptop_screen;
            case "Desktop + 2 screens":
                return EquipmentEnums.desktop_2screens;
            case "Laptop* + screen at office + screen at home":
                return EquipmentEnums.laptop_office_home;
            case "Desktop + screen + laptop":
                return EquipmentEnums.desktop_screen_laptop;
            default:
                return EquipmentEnums.desktop_screen;
        }
    }
    
    
}
