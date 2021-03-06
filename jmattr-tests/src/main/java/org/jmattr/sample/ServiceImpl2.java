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

package org.jmattr.sample;

import org.jmattr.meta.api.Meta;
import org.jmattr.meta.api.Provider;

/**
 * Created by vj on 3/9/16.
 */
@Provider(
        value = "sample.ServiceImpl2",
        type = Service.class,
        doc = "This is a Sample Service Implementation 1",
        meta = {
                @Meta(attribute = "attribute1",value = "value1")
        }
)
public class ServiceImpl2 implements Service{
    @Override
    public String getName() {
        return "Service Implementation 2";
    }

    @Override
    public String getDescription() {
        return "Service Implementation 2 description";
    }}
