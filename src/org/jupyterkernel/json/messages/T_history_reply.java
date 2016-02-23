/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jupyterkernel.json.messages;

import org.json.JSONArray;
import org.jupyterkernel.util.JSONField;

/**
 *
 * @author kay schluehr
 */
public class T_history_reply extends T_JSON {
    @JSONField
    public JSONArray history = new JSONArray();
}
