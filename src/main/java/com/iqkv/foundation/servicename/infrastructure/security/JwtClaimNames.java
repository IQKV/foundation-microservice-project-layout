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

package com.iqkv.foundation.servicename.infrastructure.security;

/**
 * Custom JWT claim names used by the IQKV platform.
 *
 * <p>These claims are set by the IAM service when issuing tokens and are read
 * by every resource server (this service, billing, CMS, etc.) to extract
 * tenant context and granted authorities.
 *
 * <p>Must be kept in sync with the IAM service {@code JwtClaimNames} class.
 */
public final class JwtClaimNames {

  /**
   * Claim carrying the tenant key (8-character NanoID).
   * Absent or {@code null} on platform-admin tokens — those operate cross-tenant.
   */
  public static final String TENANT_ID = "tenant_id";

  /**
   * Claim carrying the list of granted authority strings, e.g.
   * {@code ["ROLE_USER", "TENANT_OWNER"]}. Mapped to Spring Security
   * {@code GrantedAuthority} instances by the {@code JwtAuthenticationConverter}.
   */
  public static final String AUTHORITIES = "authorities";

  private JwtClaimNames() {
  }
}
