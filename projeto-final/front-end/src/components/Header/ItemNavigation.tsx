import { Text } from '@chakra-ui/react'

type ItemNavigationProps = {
  text: string,
  redirect: string
}

export function ItemNavigation ({ text, redirect }: ItemNavigationProps) {
  return (
    <Text
      as="a"
      href={redirect}
      display="flex"
      alignItems="center"
      height="100%"
      fontSize={20}
      fontWeight="medium"
      color="yellow.800"
      padding="16px"
      borderRadius="8px"
      _hover={{
        backgroundColor: 'yellow.800',
        color: 'white'
      }}
      >
      {text}
    </Text>
  )
}
