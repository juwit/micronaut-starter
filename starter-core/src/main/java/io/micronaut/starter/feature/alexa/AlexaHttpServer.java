/*
 * Copyright 2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.starter.feature.alexa;

import io.micronaut.starter.feature.Feature;

import javax.inject.Singleton;

@Singleton
public class AlexaHttpServer implements Feature {

    @Override
    public String getName() {
        return "alexa-http-server";
    }

    @Override
    public String getTitle() {
        return "Alexa Http Server";
    }

    @Override
    public String getDescription() {
        return "Adds support for hosting a Custom Skill as a Web Service (https://developer.amazon.com/en-US/docs/alexa/custom-skills/host-a-custom-skill-as-a-web-service.html).";
    }

}
