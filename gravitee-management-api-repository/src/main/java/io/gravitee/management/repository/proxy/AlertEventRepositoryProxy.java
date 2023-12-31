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
package io.gravitee.management.repository.proxy;

import io.gravitee.common.data.domain.Page;
import io.gravitee.repository.exceptions.TechnicalException;
import io.gravitee.repository.management.api.AlertEventRepository;
import io.gravitee.repository.management.api.search.AlertEventCriteria;
import io.gravitee.repository.management.api.search.Pageable;
import io.gravitee.repository.management.model.AlertEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
@Component
public class AlertEventRepositoryProxy extends AbstractProxy<AlertEventRepository> implements AlertEventRepository {

    public Page<AlertEvent> search(AlertEventCriteria criteria, Pageable pageable) {
        return target.search(criteria, pageable);
    }

    public void deleteAll(String alertId){
        target.deleteAll(alertId);
    }

    public Optional<AlertEvent> findById(String s) throws TechnicalException {
        return target.findById(s);
    }

    public AlertEvent create(AlertEvent item) throws TechnicalException {
        return target.create(item);
    }

    public AlertEvent update(AlertEvent item) throws TechnicalException {
        return target.update(item);
    }

    public void delete(String s) throws TechnicalException {
        target.delete(s);
    }
}
