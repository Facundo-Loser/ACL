data Tree a = Nil | Node a (Tree a) (Tree a) deriving (Show, Eq)

buildTree :: [a] -> (Tree a)
buildTree [] = Nil
buildTree (x:xs) =