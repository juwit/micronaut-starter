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
package io.micronaut.starter.feature.picocli;

import io.micronaut.starter.options.Options;
import io.micronaut.starter.application.generator.GeneratorContext;
import io.micronaut.starter.application.ApplicationType;
import io.micronaut.starter.feature.DefaultFeature;
import io.micronaut.starter.feature.Feature;
import io.micronaut.starter.feature.FeatureContext;
import io.micronaut.starter.feature.picocli.test.junit.PicocliJunit;
import io.micronaut.starter.feature.picocli.test.kotlintest.PicocliKotlinTest;
import io.micronaut.starter.feature.picocli.test.spock.PicocliSpock;
import io.micronaut.starter.options.BuildTool;
import io.micronaut.starter.options.TestFramework;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class Picocli implements DefaultFeature {

    private final PicocliJunit junit;
    private final PicocliSpock spock;
    private final PicocliKotlinTest kotlinTest;

    public Picocli(PicocliJunit junit, PicocliSpock spock, PicocliKotlinTest kotlinTest) {
        this.junit = junit;
        this.spock = spock;
        this.kotlinTest = kotlinTest;
    }

    @Override
    public String getName() {
        return "picocli";
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public boolean shouldApply(ApplicationType applicationType, Options options, List<Feature> selectedFeatures) {
        return applicationType == ApplicationType.CLI;
    }

    @Override
    public String getTitle() {
        return "PicoCLI";
    }

    @Override
    public String getDescription() {
        return "Support for creating PicoCLI applications";
    }

    @Override
    public void processSelectedFeatures(FeatureContext featureContext) {
        if (featureContext.getTestFramework() == TestFramework.JUNIT) {
            featureContext.addFeature(junit);
        } else if (featureContext.getTestFramework() == TestFramework.SPOCK) {
            featureContext.addFeature(spock);
        } else if (featureContext.getTestFramework() == TestFramework.KOTLINTEST) {
            featureContext.addFeature(kotlinTest);
        }
    }

    @Override
    public void apply(GeneratorContext generatorContext) {
        if (generatorContext.getBuildTool() == BuildTool.MAVEN) {
            generatorContext.getBuildProperties().put("micronaut.picocli.version", "1.2.1");
        }
    }
}
