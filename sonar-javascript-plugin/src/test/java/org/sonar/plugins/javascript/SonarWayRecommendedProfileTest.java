/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011-2018 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.plugins.javascript;

import org.junit.Test;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.javascript.checks.CheckList;

import static org.assertj.core.api.Assertions.assertThat;

public class SonarWayRecommendedProfileTest {

  @Test
  public void should_create_sonar_way_recommended_profile() {
    SonarWayRecommendedProfile definition = new SonarWayRecommendedProfile();
    BuiltInQualityProfilesDefinition.Context context = new BuiltInQualityProfilesDefinition.Context();
    definition.define(context);
    BuiltInQualityProfilesDefinition.BuiltInQualityProfile profile = context.profile(JavaScriptLanguage.KEY, SonarWayRecommendedProfile.PROFILE_NAME);


    assertThat(profile.language()).isEqualTo(JavaScriptLanguage.KEY);
    assertThat(profile.name()).isEqualTo(SonarWayRecommendedProfile.PROFILE_NAME);
    assertThat(profile.rules()).extracting("repoKey").containsOnly("common-js", CheckList.REPOSITORY_KEY);
    assertThat(profile.rules().size()).isGreaterThan(110);
  }

}
