/*
 * Copyright 2026 IQKV Foundation Team.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.iqkv.foundation.servicename.infrastructure.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Binds {@code iqkv.auth.*} from {@code application.yml}.
 *
 * <p>This service is a JWT resource server — it only needs the RSA public key
 * to verify tokens issued by the IAM service. It does not issue tokens and
 * therefore does not hold a private key.
 *
 * <p>The full auth config (expiry, refresh, security, password-reset, magic-link)
 * lives in the IAM service. Add those sub-records here only if this service
 * needs to issue its own tokens.
 */
@Validated
@ConfigurationProperties(prefix = "iqkv.auth")
public record AuthConfigurationProperties(
    @Valid @NotNull Jwt jwt
) {

  public record Jwt(
      // Path to the RSA public key PEM file used to verify JWTs from the IAM service.
      // Accepts classpath: (local/test) or file: (deployed) resources.
      @NotBlank String publicKeyPath
  ) {
  }
}
