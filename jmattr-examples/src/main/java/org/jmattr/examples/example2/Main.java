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

package org.jmattr.examples.example2;

import org.apache.commons.vfs2.FileSystemException;
import org.jmattr.examples.simpleimpl.SampleServiceImpl;
import org.jmattr.registry.api.Registry;
import org.jmattr.registry.api.UnknownNameException;

import static org.jmattr.meta.impl.DefaultScannerFactory.getDefaultScanner;

/**
 * Created by vj on 3/19/16.
 */
public class Main {

    public static void main(String[] args) throws FileSystemException, UnknownNameException {
        Registry registry = getDefaultScanner().getRegistry();

        SampleServiceImpl serviceImpl = registry.lookup("sample.SampleServiceImpl", SampleServiceImpl.class);

        assert serviceImpl.getName().equals("SampleServiceImpl");

        System.out.println("SampleServiceImpl : "+serviceImpl.getName());
    }
}
