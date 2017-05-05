/*
 * Copyright 2017 kay.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jupyterkernel.console;

import org.jupyterkernel.json.messages.T_kernel_info_reply;

/**
 *
 * @author kay
 */
public interface IInteractiveConsole {

    // language specific -- not implemented here
    String[] completion(String source, int cursor_position);

    /**
     *
     * @param codeString source code which is evaluted by the ScriptEngine
     * @return result of the evaluation
     *
     */
    Object eval(String codeString);

    // used to handle complete_request message
    int getCompletionCursorPosition();

    T_kernel_info_reply getKernelInfo();

    String getMIMEType();

    String[] getTraceback();

    String readAndClearStderr();

    String readAndClearStdout();

    void setCellNumber(int cell);

    void setStdinReader(ConsoleInputReader reader);

    void setStreamWriter(JupyterStreamWriter streamWriter);

    void stopStreaming();
    
}
