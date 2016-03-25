/*
 *
 * Copyright (c) 2016. Vijayakumar Mohan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * JMattr - The meta attribute library for java!
 *
 */

package org.jmattr.examples.attribute;


import org.jmattr.examples.common.SampleConstants;
import org.jmattr.meta.api.AttributeProvider;
import org.jmattr.registry.api.Registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.jmattr.common.utils.StringUtil.fmt;

/**
 * Created by vj on 3/14/16.
 */
public class SampleAttributeProvider implements AttributeProvider {

    private Registry registry;

    @Override
    public void setContext(Object context) {
        registry = (Registry)context;
    }

    @Override
    public Map<String, Function<Object, ?>> getAttributeMap() {

        HashMap<String,Function<Object,?>> attributeMap = new HashMap<>();

        addProviderAttributeHandler(attributeMap);

        return attributeMap;
    }

    private void addProviderAttributeHandler(HashMap<String, Function<Object, ?>> attributeMap) {
        attributeMap.put(SampleConstants.ATT_PROVIDER,(value)->{
            //System.out.println(fmt("About to transfor %s to a provider",value));
            //Provider is just a string so just do the base validation checks and return the value
            String retVal = value.toString().trim().length() > 0 ? value.toString() : null;
            if(retVal == null){
                throw new AssertionError(fmt("invalid value \"%s\" for Attribute(%s)",value, SampleConstants.ATT_PROVIDER));
            }

            return retVal;

        });
    }
}
