<!DOCTYPE html>
<html>

<head>
	<title>Generated Report</title>
	<style>
		<#include "Style.css">
	</style>
</head>
<body>
	
	<!-- Rolling header and footer -->
	<div id="pageHeader">
		<div id="logo" class="mediaLogo" data-src="logo.png"/>
		<div id="username">
			${(user.firstname)!"---"} ${(user.lastname)!"---"}
		</div>
		<div id="title">Personal Data Dump</div>
	</div>
	
	<div id="pageFooter">
		<div id="copyright">
			© ${.now?string('yyyy')} Tieto
		</div>
		<div id="date">
			${.now?string('yyyy-MM-dd HH:mm')}
		</div>
	</div>
	
	<!-- content -->
	<div id="wrapper">	
		<table id="userInfo">
			<tr>
				<td class="leftCol">Firstname:</td>
				<td class="rightCol">${(user.firstname)!"---"}</td>
			</tr>
			<tr>
				<td class="leftCol">Lastname:</td>
				<td class="rightCol">${(user.lastname)!"---"}</td>
			</tr>
			<tr>
				<td class="leftCol">Username:</td>
				<td class="rightCol">${(user.userToken)!"---"}</td>
			</tr>
			<tr>
				<td class="leftCol">Email:</td>
				<td class="rightCol">${(user.email)!"---"}</td>
			</tr>
			<tr>
				<td class="leftCol">Registered:</td>
				<td class="rightCol">${(user.registrationDate?date)!"---"}</td>
			</tr>
			<tr>
				<td class="leftCol">SSH Key:</td>
				<td class="rightCol">${(user.sshKey)!"---"}</td>
			</tr>
		</table>
		
		<div id="structure-component">
		
			<!-- List all Companies for User-->
			<#list user.companies as company>
			<div class="company">
				<div class="dontBreak">
					<!-- Company title -->
					<div class="titleLine">
						<div class="media" data-src="assessment.png" />		<!-- image -->
			  			<span class="title">Company: ${company.title!"---"}</span>
					</div>
					
					<!-- Roles in company -->
					<div class="roles">
						<span ><i>Company Roles:</i> (</span>
		  				<#list company.userCompanyRoles as companyRole>
		  					${companyRole!"---"}
		  					<#if !companyRole?is_last>
		  						${", "}
		  					<#else>
		  						${" ) "}
		  					</#if>
		  				</#list>
					</div>
				</div>
				
				<!-- List all Projects in given Company -->
				<#list company.userProductSpaces as project>
  				<div class="project">
  					<div class="dontBreak">
  						<!-- Project Title -->
	  					<div class="titleLine">
		  					<div class="media" data-src="dvr.png" />		<!-- image -->
		  					<span class="title">Project: ${project.name!"---"}</span>
	  					</div>
	  					
	  					<!-- Roles within Project -->
						<div class="roles">
		  					<span ><i>Project Roles:</i> (</span>
	  						<#list project.userProductSpaceRoles as projectRole>
	  							${projectRole!"---"}
			  					<#if !projectRole?is_last>
			  						${", "}
			  					<#else>
			  						${" ) "}
			  					</#if>
	  						</#list>
						</div>
					</div>
					
					<!-- Temp variable is to avoid printing 'SAAS/Server' title when there is no saas/server -->
					<#assign tmp = 0>	
					<!-- List all Servers in Project of one type -->
					<#list project.servers as server>
					<div class="serverGroup">
						<!-- Prints group title -->
						<#if tmp == 0>
							<div class="title">Server</div>
							<#assign tmp = 1>
						</#if>
						
						<div class="server dontBreak">
							<div class="titleLine">
								<div class="media" data-src="desktop_windows.png" />
								<span>${server.fqdn!"---"}</span>
							</div>
							
							<div class="serverInfo">
							<table class="auth">
									<td class="leftCol">Auth: ( ${server.authentication!"---"} )</td>
									<td class="nonBreakLine"><i>User Role: </i> (
									
									<#if !server.serverRoles?has_content>
										${"--- ) "}
									<#else>
										<#list server.serverRoles as role>
											${role}
											<#if !role?is_last>
						  						${", "}
						  					<#else>
						  						${" )"}
						  					</#if>
										</#list>
									</#if>
									</td>
							</table>
							</div>
						</div>
					</div>
					</#list>
					
					<#assign tmp = 0>	
					<!-- List all Servers in Project of one type -->
					<#list project.saas as server>
					<div class="serverGroup">
						<!-- Filters out Servers -->
						<#if server.aurUserPersonalData?has_content>
						
							<!-- Prints group title-->
							<#if tmp == 0>
								<div class="dontBreak">
								<div class="title">SAAS</div>
							</#if>
							
							<div class="server">
							<div class="titleLine">
								<div class="media" data-src="settings_system_daydream.png" />
								<span>${server.name!"---"} - ${server.fqdn!"---"}</span>
							</div>
							</div>
							
							<!-- Page break handling so that title doesn't stay alone -->
							<#if tmp == 0>
								</div>
								<#assign tmp = 1>
							</#if>
							
							<div class="server">
							<div class="saasEntities breakable">
								<#assign aupd= server.aurUserPersonalData>
								<#if aupd.entities??>
									<#list aupd.entities as ent>
										<#if ent??>
											<li class="entity">
											<table>
												<tr>
													<td class="leftCol">${ent.fields["entity-name"]}</td>
													
													<td class="nonBreakLine"><i>Roles </i> (
													
													<#if !ent.userRoles?has_content>
														${"--- ) "}
													<#else>
														<#list ent.userRoles as role>
															${role}
															<#if !role?is_last>
										  						${", "}
										  					<#else>
										  						${" ) "}
										  					</#if>
														</#list>
													</#if>
													
													
													</td>
												</tr>
											</table>
											</li>
										</#if>
									</#list>
								</#if>
							</div>
							</div>

						</#if>
					</div>
					</#list>
					
					
  				</div>
  				</#list>
			</div>
			</#list>
		
		</div>
	</div>
</body>
</html>