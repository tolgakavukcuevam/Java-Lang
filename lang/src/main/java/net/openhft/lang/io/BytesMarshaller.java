/*
 * Copyright 2013 Peter Lawrey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.openhft.lang.io;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * External marshaller for classes.
 *
 * @author peter.lawrey
 * @see BytesMarshallable
 */
public interface BytesMarshaller<E> {
    /**
     * @return super class of classes marshalled/
     */
    @NotNull
    Class<E> classMarshaled();

    /**
     * write the object out as bytes.
     *
     * @param bytes to write to
     * @param e     to write
     */
    void write(Bytes bytes, E e);

    /**
     * Read bytes and obtain an object
     *
     * @param bytes to read
     * @return the object
     */
    @Nullable
    E read(Bytes bytes);

    /**
     * Write in a form which can be parsed
     *
     * @param bytes to write to
     * @param e     to write
     */
    void append(Bytes bytes, E e);

    /**
     * Parse a stream up to a known stop character
     *
     * @param bytes  to read
     * @param tester to know when to stop.
     * @return the object.
     */
    @Nullable
    E parse(Bytes bytes, StopCharTester tester);
}