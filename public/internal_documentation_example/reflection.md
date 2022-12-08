# Sample Internal Documentation
This is a partially public-facing documentation: the Javadoc is externally visible to all users of this class, and the comments within the function body are visible to just the owner of the file. By convention, the Javadoc should be more structured and written with formalism, but the internal comments have little restriction as long as it will be helpful to you - the owner - in the future when you revisit your code for maintenance.

<br/><br/>

## Javadoc
**Audience:** Engineers who are the users of this class and know the Javadoc convention.

**Expectation:** The documentations should follow the Oracle standard and define every variable introduced and involved.

**Convention:** The parameters, side effects, and returns are clearly defined using the Oracle standard.

Since there is a universal standard on this documentation, you should follow the standard where every variable involved in the function is defined atomically with a simple sentence. These documentations will be used and maintained for decades, so the content needs to be clear and stable.

<br/><br/>

## Private comment
**Audience:** Myself - owner - now and in the future

**Expectation:** I should be able to understand what this program does with these messages to myself.

Since no one else will read/care about these comments, they are formatted more casually using what every form that is the most convenient to you. In this case, I included illustrations and notes that will help me to understand what my function does.
