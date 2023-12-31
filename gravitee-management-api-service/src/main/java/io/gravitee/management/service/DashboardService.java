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
package io.gravitee.management.service;

import io.gravitee.management.model.DashboardEntity;
import io.gravitee.management.model.NewDashboardEntity;
import io.gravitee.management.model.UpdateDashboardEntity;
import io.gravitee.repository.management.model.DashboardReferenceType;

import java.util.List;

/**
 * @author Azize ELAMRANI (azize at graviteesource.com)
 * @author GraviteeSource Team
 */
public interface DashboardService {
    List<DashboardEntity> findAll();
    List<DashboardEntity> findByReferenceType(DashboardReferenceType referenceType);
    DashboardEntity findById(String dashboardId);
    DashboardEntity create(NewDashboardEntity dashboard);
    DashboardEntity update(UpdateDashboardEntity dashboard);
    void delete(String dashboardId);
}
