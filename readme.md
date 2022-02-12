# HypeApi Lib

## Getting started:

### Basic usage:

```
APIResponse resp = new APIRequest().withEndpoint(APIEndpoint.HYPIXEL_GAMES).sendRequest(); //also includes chainable .withUUID() and .withKey() which are self explanitory
System.out.println(resp.getParsedMap().get("success").toString);
System.out.println(resp.getParsedMap().getChildMap("games").get("QUAKECRAFT").toString);
```

### Other useful things:

```
APIUtils.tryParseAll(Object val)
```
Tries to parse a value as all different types of variables and returns the first one that succeeds, or the orignal if it fails, as a custom type 'ParsedValue' with methods:
```
ParsedValue.getType() //returns the type of the parsed value i.e. "java.lang.Boolean" for casting purposes
ParsedValue.getValue() //returns the value i.e. 'true'
ParsedValue.isParseSuccessful() //returns true if the value was succefully parsed to a value
```

APIList and APIMap are custom types that extend list and map respectivley but have a few helpful methods
```
APIMap.hasChildMap(String name) //returns true if this map contains another map with this name as a key
APIMap.getChildMap(String name) //returns a Map<String, Object> with the given name or throws IsNotMapException
APIMap.hasChildList(String name) //returns true if this map contains a list with this name as a key
APIMap.getChildList(String name) //returns a List<Object> with the given name or throws IsNotListException
```

```
APIList.hasChildMap(int index) //returns true if this list contains a map at this index
APIList.getChildMap(int index) //returns a Map<String, Object> with the given index or throws IsNotMapException
APIList.hasChildList(int index) //returns true if this list contains another list with this index
APIList.getChildList(int index) //returns a List<Object> with the given index or throws IsNotListException
```


#### Extras
APIEndpoints.SKYBLOCK_AUCTIONS has a .withPage(int num) that allows you to get a page of th ah use it like this new APIRequest.withEndpoint(APIEndpoints.SKYBLOCK_AUCTIONS.withPage(3)).sendRequest

Happy modding :)
