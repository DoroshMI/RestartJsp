package com.epam.lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class RestartJsp {

	private static void replaceFilesJsp(String projectFolder, String srcJsp, String tomcatFolder, String baseURLProject)
			throws Exception {

		String projectFolderJsp = projectFolder + "\\src\\main\\webapp\\" + srcJsp;

		String serverFolderJsp = tomcatFolder + "\\webapps\\" + baseURLProject + "\\" + srcJsp;

		System.out.println(projectFolderJsp);
		System.out.println(serverFolderJsp);

		FilesUtil.delete(serverFolderJsp);
		FilesUtil.copy(projectFolderJsp, serverFolderJsp);

	}

	public static void main(String[] args) throws Exception {
		String projectFolder = "D:\\CourseHybris\\Study\\Spring\\HelloWorld";
		String srcJsp = "WEB-INF\\jsp";
		String tomcatFolder = "C:\\all\\apache-tomcat-8.0.44";
		String baseURLProject = "web";

		replaceFilesJsp(projectFolder, srcJsp, tomcatFolder, baseURLProject);

	}

}
