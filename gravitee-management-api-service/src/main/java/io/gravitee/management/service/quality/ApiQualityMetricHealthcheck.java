/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
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
package io.gravitee.management.service.quality;

import io.gravitee.definition.model.endpoint.HttpEndpoint;
import io.gravitee.definition.model.services.healthcheck.HealthCheckService;
import io.gravitee.management.model.api.ApiEntity;
import io.gravitee.management.model.parameters.Key;

/**
 * @author Nicolas GERAUD (nicolas.geraud at graviteesource.com) 
 * @author GraviteeSource Team
 */
public class ApiQualityMetricHealthcheck implements ApiQualityMetric {

    @Override
    public Key getWeightKey() {
        return Key.API_QUALITY_METRICS_HEALTHCHECK_WEIGHT;
    }

    @Override
    public boolean isValid(ApiEntity api) {
        boolean globalHC = api.getServices() != null &&
                api.getServices().getAll() != null &&
                api.getServices().getAll()
                        .stream()
                        .anyMatch(service -> service.isEnabled() && service instanceof HealthCheckService);
        if (globalHC) {
            return true;
        } else {
            return api.getProxy().getGroups().stream().allMatch(group -> group.getEndpoints().stream().allMatch(endpoint -> {
                if (endpoint instanceof HttpEndpoint) {
                    return ((HttpEndpoint) endpoint).getHealthCheck() != null &&
                            ((HttpEndpoint) endpoint).getHealthCheck().isEnabled();
                } else {
                    return false;
                }
            }));
        }
    }
}
