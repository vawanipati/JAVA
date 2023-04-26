# Dropped the columns that are not relevant to our analysis, such as customer ID, name, and email address.
Removed rows that contained missing or garbage data.
Replaced the values in the left_bank column with 0 if the value was 'No', 'N/A', 'NO', or 'N', and with 1 if the value was 'Yes' or 'Y'. This column represents the target variable we are trying to predict - whether a customer will leave the bank or not.
Converted the date columns to datetime format.
Created a new column 'days_since_communication' by calculating the difference in days between the date of last communication and the date of this analysis.
Created a new column 'days_since_incident' by calculating the difference in days between the date of the last incident reported by the customer and the date of this analysis.
Removed the string 'year' and kept only the numeric value for the 'duration of the relationship with bank' column.
Used the get_dummies function to encode the categorical variables. This function creates a new binary column for each category in a categorical variable. For example, the subscription_plan column has three categories - basic, premium, and ultimate. The get_dummies function creates three new columns, one for each category, with binary values indicating if a customer belongs to that category or not.
Used the drop_first parameter in the get_dummies function to drop one of the columns to avoid the dummy variable trap.
Scaled the numerical features using the StandardScaler function to ensure that they are on the same scale. This is important because some machine learning algorithms require features to be on the same scale for optimal performance.

Classified the types of communication based on the communication channel and the product or service offered. We created a new column called "communication_type" and assigned labels based on the combination of communication channel and product/service. For example, if the communication channel was "email" and the product/service was "credit card," the communication type was labeled as "email_credit_card". This helped us identify which types of communication were most effective in retaining customers and preventing churn.
