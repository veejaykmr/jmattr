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

package org.jmattr.examples.impl2;

import org.jmattr.examples.common.SampleConstants;
import org.jmattr.examples.common.SampleService;
import org.jmattr.meta.api.Meta;
import org.jmattr.meta.api.Provider;

/**
 * Created by vj on 3/14/16.
 */
@Provider(
        value = "app.sample.Implementation1",
        type = SampleService.class,
        doc = "Example Implementation1",
        meta = {
                @Meta(attribute = SampleConstants.ATT_PROVIDER,value = "Provider2")
        }
)
public class SampleImpl2 implements SampleService {
    @Override
    public String getName() {
        return "Implementation1";
    }

    @Override
    public String getProvider() {
        return "Implementation1-Provider2";
    }
}
