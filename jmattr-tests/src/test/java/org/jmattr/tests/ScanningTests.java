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

package org.jmattr.tests;

import org.apache.commons.vfs2.FileSystemException;
import org.jmattr.common.Constants;
import org.jmattr.meta.api.MetaScanner;
import org.jmattr.meta.impl.BaseAttributeProvider;
import org.jmattr.meta.impl.BaseFunctionProvider;
import org.jmattr.meta.impl.DefaultRTAnnotationProcessor;
import org.jmattr.registry.api.Registry;
import org.jmattr.registry.api.UnknownNameException;
import org.jmattr.registry.impl.RegistryImpl;
import org.jmattr.sample.AnotherProvider;
import org.jmattr.sample.Service;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by vj on 3/8/16.
 */
public class ScanningTests {

    private Registry registry;

    @BeforeClass
    public void setup() throws FileSystemException {
        registry = new RegistryImpl();
        //registry.validateAttributes(false);
        //BaseAttributeProvider attributeProvider = new BaseAttributeProvider();
        //attributeProvider.setContext(registry);

        //BaseFunctionProvider functionProvider = new BaseFunctionProvider();

        //registry.register(Constants.ATTRIBUTE_MAP,attributeProvider.getAttributeMap());
        //registry.register(Constants.FUNCTION_MAP,functionProvider.getFunctionMap());
        MetaScanner scanner = new MetaScanner(new DefaultRTAnnotationProcessor(),registry);
        scanner.scanAndRegister();
    }

    @Test
    public void test_SimpleServiceImpl() throws UnknownNameException {
        AnotherProvider impl1 = (AnotherProvider) registry.lookup("sample.AnotherProvider");

        assertNotNull(impl1);
        assertEquals(impl1.message(),"SimpleServiceImplementation");
    }

    @Test
    public void test_ServiceImplMultiple() throws UnknownNameException {

        //look up provider impl1
        Service impl1 = (Service)registry.lookup("sample.ServiceImpl1");

        Service impl2 = (Service)registry.lookup("sample.ServiceImpl2");

        assertNotEquals(impl1,impl2);

        assertEquals(impl1.getName(),"Service Implementation 1");
        assertEquals(impl2.getName(),"Service Implementation 2");
    }


    @Test
    public void test_RequestScopeTest() throws UnknownNameException {
        Service impl1 = (Service)registry.lookup("sample.ServiceImpl1");

        Service impl2 = (Service)registry.lookup("sample.ServiceImpl1");

        assertNotEquals(impl1,impl2);

        assertEquals(impl1.getName(),"Service Implementation 1");
        assertEquals(impl2.getName(),"Service Implementation 1");

    }

    @Test
    public void test_SingletonScopeTest() throws UnknownNameException {
        Service impl1 = (Service)registry.lookup("sample.SingletonServiceImpl");

        Service impl2 = (Service)registry.lookup("sample.SingletonServiceImpl");

        assertEquals(impl1,impl2);

        assertEquals(impl1.getName(),"Singleton ServiceImpl");
        assertEquals(impl2.getName(),"Singleton ServiceImpl");

    }

}
