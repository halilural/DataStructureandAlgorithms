#### This repository is all about data structure and algorithms.

##### Big O notation

 Big O notation is used in computer science to describe the performance or complexity of an algorithm. Big O specifically describes the worst-case scenario, and can be used to describe the execution time required or the space used by an algorithm. It is hard to pin down the exact runtime required by an algorithm, it depends on what processor you use, what other programs the computer is running. So instead of calculating that, we use a concept to see how quickly the runtime grows. Imagine when we write a piece of code, we would more likely end up in refactoring it not just because we want to keep the application DRY, but we want to make sure the efficiency of our code, which is directly related to user experience.

Making Sense of Big O Notation
Before any example, here are some concepts you need to know first:
Size of input: we call it “n”. So we can say things like, we have a function which takes a parameter of an array of integers. Then the input here refers to the array.
The rules: In big O analysis, it only cares about the code that grows the fastest as the input grows, because everything else eclipsed(big O analysis is also called asymptotic analysis).
Now let’s take a look at the examples:
In this function, the n is 10. We can change the length of it.

```
array = [1,2,3,4,5,6,7,8,9,10];
function sum(array) {
  var total = 0;
  array.forEach(num => {
  total += num
   });
 return total 
}
=> 55
```

If we run enough time using different size of input, we can get their runtime:

![enter image description here](https://miro.medium.com/max/1400/1*cA-htu-wTCDkngSp0XbIsw.png)

It’s obvious that the runtime grows linearly as the n grows. This is called a **linear time.** Mathematically, it is expressed as T = an + b.

Remember in the rules we mentioned Big O only cares about the part where it grows the fastest? So we first find that part ( **an** ) and secondly take out the coefficient (**a**), we are left with n, and that’s O(**n**).

There are different types of time complexity:
- **Linear Time** (example above) => O(n)
- **Constant Time** (runtime doesn’t change whatever the input is) => O(1)
- **Quadratic Time** (the time it takes to complete a function increase like a quadratic function) => O(n²)

#### Time Complexity

How do we know which time complexity the code fits in?

(1)Let’s change our sum method a little bit:

```
array = [1,2,3,4,5,6,7,8,9,10];
function sum(array) {
 var total = 0;     // c1
  return total   // c2
}
=> 0
T = c1 + c2

```
This function doesn’t really do anything, it just return the total which is still 0. No matter how we change our array, the T stays the same. So it is a **constant time**. Mathematically it should be T = c1 + c2, let’s say c1 + c2 = c3, then if expressed in big **O**, we will have T = 1 * c3, which is **O(1)**.

(2)Let’s look at our original sum function again:

```
function sum(array) {
 var total = 0;                    //O(1) 
  array.forEach(num => {
  total += num                 //n * O(1)    
   }); 
return total               // O(1)
}

```

If we add them up together, we will get **T = O(1) + n*O(1) + O(1)**. Let’s say each O(1) has their own time c1, c2, c3, the time for O(1) + O(1) = c4, we have **T = c4 + n * c2**. Using big O expression, we get the fastest part n * c2, and we remove the coefficient, we get O(n).

(3) If we twist our sum function, we want to find out the pair sum of each number in this array (sum of each number with each number in the array)

```
function pairSum(array) {
 var total = 0;                           //O(1)
  array.forEach(firstNum => {
    array.forEach(secondNum =>{
      total += firstNum + secondNum  n² * O(1)
      })        
   });
 return total                        //O(1)      
}

```
We add them up and get **T = O(1) + n² * O(1) + O(1)**. Using the same logic, we know the sum of first and last O(1) is a constant, let’s say c5, the we will have **T = c5 + n² * O(1)**. If we take out the coefficient from the fastest part, we get **O(n²)**.

 #### Space Complexity

 Space complexity is very similar to time complexity. In some cases, we just want to optimize our memory instead of saving more time.

(1) The function below takes O(1) space. It takes a fixed amount of space which doesn’t depend on the input.

```
function sum(array) {
 var total = 0; 
 for (let i = 0; i < array.length; i++) {
    console.log("${total}");
  }                                          
}
```

(2)This function takes O(n) space because the size of hiArray scales as the input size grows.

```
function sayHiNTimes(n) {
 const hiArray = []; 
 for (let i = 0; i < n; i++) {
    hiArray[i] = 'hi';
  }
    return hiArray;
}
```

(3) This function takes O(1) space even though the input has n items. It takes a fixed amount of space that is not depend on the input.

```
function getLargestItem(items) {
  let largest = -Number.MAX_VALUE;
  items.forEach(item => {
    if (item > largest) {
      largest = item;
    }
  });
  return largest;
}

```

#### How Should We Optimize Our Code?

If we have different solutions for one question, we can compare their runtime to get the answer. When they achieve the same thing, constant time O(1) is probably better than linear time O(n). However, time complexities is not the only factor you should take into account. You should also consider is your code readable enough, how much memory is your code going to consume.

#### Resources

A beginner’s guide to Big O Notation https://rob-bell.net/2009/06/a-beginners-guide-to-big-o-notation/

Big O Notation: https://www.interviewcake.com/article/javascript/big-o-notation-time-and-space-complexity

Big O Notation and Time Complexity https://www.youtube.com/watch?v=D6xkbGLQesk
