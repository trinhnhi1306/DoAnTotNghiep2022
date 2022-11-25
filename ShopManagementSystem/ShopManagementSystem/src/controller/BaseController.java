/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import output.ResponseMessage;

/**
 *
 * @author TRINH
 */
public class BaseController {

    public Gson gson = new Gson();
    public String getOneByID;
    public String getAll;
    public String addOne;
    public String editOrDelete;
    public String getItemInOnePage;
    public String getImage;
    
    public ResponseMessage convertResponse(String str) {
        ResponseMessage message = gson.fromJson(str, ResponseMessage.class);
        return message;
    }
}
