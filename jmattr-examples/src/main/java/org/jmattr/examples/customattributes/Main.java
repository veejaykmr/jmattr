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

package org.jmattr.examples.customattributes;

import org.apache.commons.vfs2.FileSystemException;
import org.jmattr.examples.common.SampleConstants;
import org.jmattr.examples.common.SampleService;
import org.jmattr.meta.api.MetaScanner;
import org.jmattr.meta.impl.DefaultScannerFactory;
import org.jmattr.registry.api.Registry;
import org.jmattr.registry.api.UnknownNameException;

/**
 * A custom attribute example.
 * Demonstrates the ability to add custom attributes
 *
 * Created by vj on 3/14/16.
 */
public class Main {


    public static void main(String[] args) throws FileSystemException, UnknownNameException {

        MetaScanner scanner = DefaultScannerFactory.getDefaultScanner();

        Registry registry = scanner.getRegistry();

        System.out.println("Registry Contents : "+registry);
        //look up the different providers


        SampleService implDefault = registry.lookup("app.sample.Implementation1",SampleService.class,(registryEntry) -> {
            boolean retVal = false;
            if(registryEntry.hasAttribute(SampleConstants.ATT_PROVIDER) &&
                    registryEntry.attribute(SampleConstants.ATT_PROVIDER)
                    .equals(SampleConstants.VAL_PROVIDER_DEFAULT)){
                retVal = true;
            }
            return retVal;
        });


        SampleService implProvider2 = registry.lookup("app.sample.Implementation1",SampleService.class,registryEntry -> {
            boolean retVal = false;
            if(registryEntry.hasAttribute(SampleConstants.ATT_PROVIDER) &&
                    registryEntry.attribute(SampleConstants.ATT_PROVIDER)
                            .equals("Provider2")){
                retVal = true;
            }
            return retVal;

        });

        assert implDefault.getName().equals("Implementation1");
        assert implProvider2.getName().equals(implDefault.getName());
        assert implProvider2 != implDefault;

        System.out.println("Default Provider : "+implDefault.getProvider());
        System.out.println("Provider2 : "+implProvider2.getProvider());
    }
}
