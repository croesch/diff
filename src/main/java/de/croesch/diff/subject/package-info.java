/**
 * Describes the different subjects available for diffing. A subject (at the top level) can be considered as a mode
 * of the diff. Each subject is built out of many subsubjects. These subsubjects are also subjects and therefore
 * built up by subsubjects, too. So the classes in this package define
 * <ul>
 *     <li>which subjects are available</li>
 *     <li>how these subjects are split up</li>
 *     <li>how the identity of a subject is defined</li>
 * </ul>
 */
package de.croesch.diff.subject;