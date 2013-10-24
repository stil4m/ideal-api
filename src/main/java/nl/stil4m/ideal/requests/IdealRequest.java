// Copyright 2013 Mats Stijlaart
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package nl.stil4m.ideal.requests;

import nl.stil4m.ideal.responses.Response;

import java.util.HashMap;
import java.util.Map;

public abstract class IdealRequest<T extends Response> {

    private final Map<String, String> data;

    private Class<T> responseClazz;

    protected IdealRequest(Class<T> responseClazz, boolean testMode) {
        this.responseClazz = responseClazz;
        this.data = new HashMap<>();
        if (testMode) {
            this.data.put("testmode", "true");
        }
    }

    public final Map<String, String> getData() {
        return data;
    }

    public Class<T> getResponseClass() {
        return responseClazz;
    }

}