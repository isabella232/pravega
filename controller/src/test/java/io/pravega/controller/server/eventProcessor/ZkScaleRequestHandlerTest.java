/**
 * Copyright (c) Dell Inc., or its subsidiaries. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package io.pravega.controller.server.eventProcessor;

import io.pravega.controller.store.stream.StreamMetadataStore;
import io.pravega.controller.store.stream.StreamStoreFactory;
import io.pravega.controller.store.VersionedMetadata;

public class ZkScaleRequestHandlerTest extends ScaleRequestHandlerTest {
    @Override
    <T> Number getVersionNumber(VersionedMetadata<T> versioned) {
        return versioned.getVersion().asIntVersion().getIntValue();
    }

    @Override
    StreamMetadataStore getStore() {
        return StreamStoreFactory.createZKStore(zkClient, executor);
    }
}
