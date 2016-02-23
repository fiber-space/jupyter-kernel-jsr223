/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jupyterkernel.json.messages;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.jupyterkernel.util.JSONField;

/**
 *
 * @author kay schluehr
 */
public class T_message extends T_JSON {

    @JSONField(type = "T_JSON")
    public T_header header;

    @JSONField(type = "T_JSON")
    public T_header parent_header;

    @JSONField
    public JSONObject metadata = new JSONObject();

    @JSONField(type = "T_JSON")
    public T_JSON content;

}
