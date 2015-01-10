package com.peter.left.interview.emc.lastAccessFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * Class to get most recently accessed file in given file uris.
 * 
 * <p>
 * Should use java 7.0 or later version because it uses the NIO2 function in java 7.
 * <p>
 * Note: User must guarantee during the whole programming running time, 
 * none of given files is accessed. Otherwise, the result is undefined or meaningless.
 * Because the program retrieves the last access time of files one by one, 
 * if a file which has already been processed is accessed before program end, 
 * this new access operation won't be considered.
 * <p>
 * Note: If user provide too much parameters (file paths) or the parameters are too long.
 * The program will fail unpredictable because of the limit of shell (Normally JVM has larger limit).
 * <p>
 * Note: Make sure it's reasonable when dealing with files from different machines (with remote path), 
 * most of the time, lacking clock synchronization will make the result meaningless.
 */
public class Solution
{
	/**
	 * Return the most recently accessed file uri in {@link uris}, null if all uris in {@link uris}
	 * are illegal.
	 * 
	 * @param uris array contains all files' uri need to compare.
	 * @return uri of the most recently accessed file, null if all uris in {@link uris} are illegal
	 */
	public String lastAccessedFile(final String[] uris)
	{
		String result = null;
		// current last access time.
		FileTime last = null;
		for (final String uri : uris)
		{
			try
			{
				final Path path = Paths.get(uri);
				final BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
				final FileTime access = attrs.lastAccessTime();
				// It's first one or this one has more recently access time.
				if (null == last || last.compareTo(access) < 0)
				{
					last = access;
					result = uri;
				}
			}
			// If there is any wrong with a uri, skip it and output the exception information.
			catch (final Exception e)
			{
				System.err.println("File \"" + uri + "\" failed. exception :"+ e);
				continue;
			}
		}
		
		return result;
	}
	
	public static void main(final String[] args)
	{
		if (0 == args.length)
		{
			System.err.println("Usage : java program <file path 1> ...");
		}
		else
		{
			final Solution solution = new Solution();
			final String last = solution.lastAccessedFile(args);
			if (null == last)
			{
				System.err.println("All paths given have something wrong, please check!");
			}
			else
			{
				System.out.println(last);
			}
		}
	}
}
