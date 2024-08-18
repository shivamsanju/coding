Here's a well-formatted version for readability:

---

## Step 1: Features

1. **Add friends**
2. **Create / Manage groups**
3. **Add / Manage friends inside a group**
4. **Add / Manage expense directly with user**
5. **Add / Manage expense inside a group**
6. **Split expenses capability**
   - Equal
   - Unequal
   - Percentage
7. **Getting balance sheet of each user**

---

## Step 2: Object Identification

1. **Splitwise**
2. **User**
3. **Group**
4. **Expense**
5. **Split**
6. **BalanceSheet**

---

## Step 3: Design Questions

1. **What happens when we create an expense?**

   For example, creating an expense for "Lunch" with unequal splitting among friends:

   ```json
   POST /create-expense
   {
       "group": "",
       "expense": "Lunch",
       "user1": "100",
       "user2": "200"
   }
   ```
---