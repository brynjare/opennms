<%--
/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2017 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2017 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

--%>

<jsp:include page="/includes/bootstrap.jsp" flush="false">
    <jsp:param name="title" value="Node List" />
    <jsp:param name="headTitle" value="Node List" />
    <jsp:param name="breadcrumb" value="Node List" />
    <jsp:param name="script" value='<script type="text/javascript" src="lib/angular/angular.js"></script>' />
    <jsp:param name="script" value='<script type="text/javascript" src="lib/angular-resource/angular-resource.js"></script>' />

    <jsp:param name="script" value='<script type="text/javascript" src="js/angular-onmsList.js"></script>' />
    <jsp:param name="script" value='<script type="text/javascript" src="js/angular-onmsList-node.js"></script>' />
</jsp:include>

<ng-include src="'status/node/main.html'"></ng-include>

<jsp:include page="/includes/bootstrap-footer.jsp" flush="false"/>