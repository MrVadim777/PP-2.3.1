package org.example.validation;

import org.example.validation.group.EmailGroup;
import org.example.validation.group.NotBlankGroup;
import org.example.validation.group.SizeGroup;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({NotBlankGroup.class, SizeGroup.class, EmailGroup.class, Default.class})
public interface ValidationOrder {
}
